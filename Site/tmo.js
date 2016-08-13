(function() {
	window.Main = {};
	Main.Page = (function() {
		var mosq = null;
		var topic = $('#sub-topic-text').val();		
		function Page() {
			var _this = this;
			mosq = new Mosquitto();

			$('#connect-button').click(function() {
				return _this.connect();
			});
			
			$('#disconnect-button').click(function() {
				return _this.disconnect();
			});
			
			//sintaxe da strign enviada: MMM>SS>A
			//Onde:
			//M: dígito do módulo
			//S: dígito da saída
			//A: dígito da ação
			
			//-----------------------------
			// Botões de ação do módulo 1
			//-----------------------------
			$('#botao-ligar-modulo1-saida1').click(function() {								
				var payload = "111";  
				var TopicPublish = $('#pub-topic-text')[0].value;
				//var x = document.getElementById("data-hora-acao").value;				
				mosq.publish(TopicPublish, payload, 0);				
			});
			
			$('#botao-desligar-modulo1-saida1').click(function() {
				var payload = "110"; 
				var TopicPublish = $('#pub-topic-text')[0].value;
				mosq.publish(TopicPublish, payload, 0);
			});
			
			$('#botao-ligar-modulo1-saida2').click(function() {
				var payload = "121";  
				var TopicPublish = $('#pub-topic-text')[0].value;
				mosq.publish(TopicPublish, payload, 0);
			});
			
			$('#botao-desligar-modulo1-saida2').click(function() {
				var payload = "120";  
				var TopicPublish = $('#pub-topic-text')[0].value;
				mosq.publish(TopicPublish, payload, 0);
			});
			
			$('#botao-ligar-modulo1-saida3').click(function() {
				var payload = "131";  
				var TopicPublish = $('#pub-topic-text')[0].value;
				mosq.publish(TopicPublish, payload, 0);
			});
			
			$('#botao-desligar-modulo1-saida3').click(function() {
				var payload = "130";  
				var TopicPublish = $('#pub-topic-text')[0].value;
				mosq.publish(TopicPublish, payload, 0);
			});
					
			//-----------------------------
			// Botões de ação do módulo 2
			//-----------------------------
			$('#botao-ligar-modulo2-saida1').click(function() {
				var payload = "211";  
				var TopicPublish = $('#pub-topic-text')[0].value;
				mosq.publish(TopicPublish, payload, 0);
			});
			
			$('#botao-desligar-modulo2-saida1').click(function() {
				var payload = "210";
				var TopicPublish = $('#pub-topic-text')[0].value;
				mosq.publish(TopicPublish, payload, 0);
			});
			
			$('#botao-ligar-modulo2-saida2').click(function() {
				var payload = "221";
				var TopicPublish = $('#pub-topic-text')[0].value;
				mosq.publish(TopicPublish, payload, 0);
			});
			
			$('#botao-desligar-modulo2-saida2').click(function() {
				var payload = "220";
				var TopicPublish = $('#pub-topic-text')[0].value;
				mosq.publish(TopicPublish, payload, 0);
			});
			
			$('#botao-ligar-modulo2-saida3').click(function() {
				var payload = "231";
				var TopicPublish = $('#pub-topic-text')[0].value;
				mosq.publish(TopicPublish, payload, 0);
			});
			
			$('#botao-desligar-modulo2-saida3').click(function() {
				var payload = "230";
				var TopicPublish = $('#pub-topic-text')[0].value;
				mosq.publish(TopicPublish, payload, 0);
			});
			
			mosq.onconnect = function(rc){
				var p = document.createElement("p");
				var topic = $('#pub-subscribe-text')[0].value;
				p.innerHTML = "<center><b><font color = 'green'>Conectado ao servidor!</font></b></center>";
				$("#debug").html(p);
				mosq.subscribe(topic, 0);
			};
			mosq.ondisconnect = function(rc){
				var p = document.createElement("p");
				var url = "ws://iot.eclipse.org/ws";
				
				p.innerHTML = "<center><b><font color = 'red'>Desconectado do servidor.</font></b></center>";
				$("#debug").html(p);
				$("#status_io").html("");
			};
			mosq.onmessage = function(topic, payload, qos){
				var p1 = document.createElement("p1");
				var p2 = document.createElement("p2");
				var p3 = document.createElement("p3");
				var ModuloQueMandouAInformacao = parseInt(payload[0]);
				var EstadoDaSaida1 = payload[1];
				var EstadoDaSaida2 = payload[2];
				var EstadoDaSaida3 = payload[3];
				
				switch(ModuloQueMandouAInformacao)
				{
					case 1:
					{
					  
						p1.innerHTML = "<img src='"+EstadoDaSaida1+".png' height='20' width='60'>";
						$("#status_io_m1s1").html(p1);
						
						p2.innerHTML = "<img src='"+EstadoDaSaida2+".png' height='20' width='60'>";
						$("#status_io_m1s2").html(p2);
						
						p3.innerHTML = "<img src='"+EstadoDaSaida3+".png' height='20' width='60'>";
						$("#status_io_m1s3").html(p3);
						
						break;
					}
					
					case 2:
					{	
                       					
         				p1.innerHTML = "<img src='"+EstadoDaSaida1+".png' height='20' width='60'>";
						$("#status_io_m2s1").html(p1);
						
						p2.innerHTML = "<img src='"+EstadoDaSaida2+".png' height='20' width='60'>";
						$("#status_io_m2s2").html(p2);
						
						p3.innerHTML = "<img src='"+EstadoDaSaida3+".png' height='20' width='60'>";
						$("#status_io_m2s3").html(p3);
						
						break;
					}
				}
				
				p.innerHTML = "<font color='white'><table><td width='50%'><tr><b>Modulo 1:</b><br> S1: <img src='"+payload_parseado[0]+".png' height='20' width='60'></tr><tr>S2: <img src='"+payload_parseado[1]+".png' height='20' width='60'></tr><tr>S3: <img src='"+payload_parseado[2]+".png' height='20' width='60'></tr><tr>S4: <img src='"+payload_parseado[3]+".png' height='20' width='60'></tr></td><br><td width='50%'><tr><br><br><b>Modulo 2:</b><br> S1: <img src='"+payload_parseado[4]+".png' height='20' width='60'></tr><tr>S2: <img src='"+payload_parseado[5]+".png' height='20' width='60'></tr><tr>S3: <img src='"+payload_parseado[6]+".png' height='20' width='60'></tr><tr>S4: <img src='"+payload_parseado[7]+".png' height='20' width='60'></tr></td></table></font>";								
				$("#status_io").html(p);
			};
		}
		Page.prototype.connect = function(){
			var url = "ws://iot.eclipse.org/ws";
			mosq.connect(url);
		};
		Page.prototype.disconnect = function(){
			mosq.disconnect();
		};
		Page.prototype.subscribe = function(){
			mosq.subscribe(topic, 0);
		};
		Page.prototype.unsubscribe = function(){
			mosq.unsubscribe(topic);
		};
		
		return Page;
	})();
	$(function(){
		return Main.controller = new Main.Page;
	});
}).call(this);
