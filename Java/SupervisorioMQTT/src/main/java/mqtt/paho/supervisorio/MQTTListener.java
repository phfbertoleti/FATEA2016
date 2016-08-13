package mqtt.paho.supervisorio;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;


public class MQTTListener implements MqttCallback {

	public void connectionLost(Throwable cause) 
	{
		// TODO Auto-generated method stub
		
	}

	public void messageArrived(String topic, MqttMessage message)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Mensagem recebida: "+message.toString());
		
		String MsgMQTT = message.toString();
		String ModuloParseado = MsgMQTT.substring(0, 1);
		String Entrada1Parseada = MsgMQTT.substring(1, 2);
		String Entrada2Parseada = MsgMQTT.substring(2, 3);
		String Entrada3Parseada = MsgMQTT.substring(3, 4);
		
		String StatusEntradas = "";
		
		if (Entrada1Parseada.equals("1"))
			StatusEntradas = StatusEntradas + "Ligado, ";
		else
			StatusEntradas = StatusEntradas + "Desligado, ";
		
		if (Entrada2Parseada.equals("1"))
			StatusEntradas = StatusEntradas + "Ligado, ";
		else
			StatusEntradas = StatusEntradas + "Desligado, ";
		
		if (Entrada3Parseada.equals("1"))
			StatusEntradas = StatusEntradas + "Ligado";
		else
			StatusEntradas = StatusEntradas + "Desligado";
		
		if (ModuloParseado.equals("1"))
			TelaPrincipal.AlteraStatusModulo1(StatusEntradas);
		else
			TelaPrincipal.AlteraStatusModulo2(StatusEntradas);
	}

	public void deliveryComplete(IMqttDeliveryToken token) 
	{
		System.out.println("Publish realizado com sucesso!");		
	}
	

    

}