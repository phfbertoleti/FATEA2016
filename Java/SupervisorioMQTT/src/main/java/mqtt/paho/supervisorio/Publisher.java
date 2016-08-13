package mqtt.paho.supervisorio;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

public class Publisher 
{
	public Publisher()
	{
		
	}
	
	public void PublicaMensagem(MqttClient ClientMQTT, String TopicoMensagem, String Mensagem, int QoSMQTT) throws MqttPersistenceException, MqttException
	{
		System.out.println("Publishing message: "+Mensagem);
        MqttMessage message = new MqttMessage(Mensagem.getBytes());
        message.setQos(QoSMQTT);
        ClientMQTT.publish(TopicoMensagem, message);        
	}
}
