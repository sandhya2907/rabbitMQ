package in.nit.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import in.nit.model.Employee;

@Service
public class RabbitMQSender {
	@Autowired
	private AmqpTemplate template;
	
	@Value("${javainuse.rabbitmq.exchange}")
	private String exchange;
	@Value("${javainuse.rabbitmq.queue}")
	private String routingKey;
	
	public void send(Employee employee) {
		template.convertAndSend(exchange,routingKey,employee);
		System.out.println(employee);
		System.out.println("Modified");
	}

}
