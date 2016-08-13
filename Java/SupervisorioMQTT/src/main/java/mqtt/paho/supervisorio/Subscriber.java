package mqtt.paho.supervisorio;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Subscriber {
	public String Topico = "ABS";
	
	public void IniciaSubscriber(MqttClient ClientMQTT, String TopicoSubscriber, int QoSMQTT) throws MqttException
	{
		ClientMQTT.subscribe(TopicoSubscriber, QoSMQTT);
		System.out.println("Subscribe no topico "+TopicoSubscriber+" feito!");
	}
}
