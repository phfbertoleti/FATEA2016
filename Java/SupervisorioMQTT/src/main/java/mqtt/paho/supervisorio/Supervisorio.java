/*
 * FATEA 2016
 * 
 * Projeto: supervis�rio MQTT
 * Descri��o: este demo tem como objetivo servir de supervis�rio simples para monitorar
 *            e controlar 6 entradas e 6 sa�das destribu�das em 2 equipamentos NodeMCU.
 *            Os objetivos s�o:
 *            1) Mostrar que o Java tem grande aplica��o no mundo IoT
 *            2) Mostrar que o mundo IoT permite  a integra��o de diversas plataformas e 
 *            sistemas, podendo estes ser escritos em linguagens totalmente diferentes 
 *            Isso faz com que o hardware e software de um projeto possam ser flex�veis, algo
 *            muito bom considerando que uma aplica��o comercial embarcada � extremamente 
 *            dependente de pre�o de hardware.
 *            3) O Java, pelo seu grande "poder de fogo", pode fazer supervis�rios e "centrais
 *            IoT" de diversos n�veis de complexidade, atendendo uma grande demanda do mercado
 *            de dispositivos IoT.
 * 
 * Autor: Pedro Bertoleti
 * Data: Agosto/2016
 */
package mqtt.paho.supervisorio;

import java.awt.image.SampleModel;
import java.sql.Timestamp;
import java.util.Arrays;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Supervisorio
{
	private static MqttClient sampleClient;  //client MQTT
	public static int QoS = 0;
	public static String topicoSubscriber  = "IoTFATEASubscriber";
	public static String topicoPublisher  = "IoTFATEAPublisher";
	public static String broker = "tcp://iot.eclipse.org:1883";
    public static String clientId = "IoTFATEA156474";
    public static MemoryPersistence persistence = new MemoryPersistence();
    public static MQTTListener listenerMQTT = new MQTTListener();
    
    public static void main(String[] args) 
    {
    	JFrame telaPrincipal = new TelaPrincipal();
        telaPrincipal.setVisible(true);    	
    }
    
    private static void DesligaTodasAsSaidas() throws MqttPersistenceException, MqttException
    {
    	Publisher pubMQTT = new Publisher();
    	
       	pubMQTT.PublicaMensagem(sampleClient, topicoPublisher, "110", QoS);
    	pubMQTT.PublicaMensagem(sampleClient, topicoPublisher, "120", QoS);
    	pubMQTT.PublicaMensagem(sampleClient, topicoPublisher, "130", QoS);
    	pubMQTT.PublicaMensagem(sampleClient, topicoPublisher, "210", QoS);
    	pubMQTT.PublicaMensagem(sampleClient, topicoPublisher, "220", QoS);
    	pubMQTT.PublicaMensagem(sampleClient, topicoPublisher, "230", QoS);
    }
    
    public static void LigaDesligaSaida(String Modulo,String Saida, String Acao)
    {
    	Publisher pubMQTT = new Publisher();
    	String ComandoMQTT = Modulo + Saida + Acao;
    	
    	try 
    	{
			pubMQTT.PublicaMensagem(sampleClient, topicoPublisher, ComandoMQTT, QoS);
		} 
    	catch (MqttPersistenceException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	catch (MqttException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private static void ConectaBroker(String broker, String clientId, MemoryPersistence persistence)
    {
    	try {
            sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            sampleClient.setCallback(listenerMQTT);
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
        } 
    	catch(MqttException me) 
    	{
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
    }
    
    
    private static void DesconectaBroker() throws MqttException
    {
    	sampleClient.disconnect();
        System.out.println("Disconnected");
    }
    
    //---------------------------------------------------------
    //m�todos utilizados para interfacear algumas a��es da tela
    //---------------------------------------------------------
    public static void FazConexaoBroker()
    {	
    	Subscriber subMQTT = new Subscriber();
    	
    	try 
    	{
    		ConectaBroker(broker, clientId, persistence);
    		DesligaTodasAsSaidas();    	
        	subMQTT.IniciaSubscriber(sampleClient, topicoSubscriber, QoS);
		} 
    	catch (MqttPersistenceException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	catch (MqttException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void FazDesconexaoBroker() 
    {
    	try 
    	{
			DesconectaBroker();
		} catch (MqttException e) {
			e.printStackTrace();
		}
    }

}
