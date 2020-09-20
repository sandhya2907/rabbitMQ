package in.nit.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.nit.model.Employee;
import in.nit.sender.RabbitMQSender;

@RestController
@RequestMapping("/rb")
public class RabbitMqRestController {

	@Autowired
	private RabbitMQSender sender;

	@GetMapping("/producer")
	public String producer(@RequestParam("empId") String empId, @RequestParam("empName") String empName) {
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		sender.send(emp);
		return "Sent RabbitMq message Successfully";

	}

}
