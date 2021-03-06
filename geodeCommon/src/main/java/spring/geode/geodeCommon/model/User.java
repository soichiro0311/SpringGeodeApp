package spring.geode.geodeCommon.model;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.gemfire.mapping.annotation.Region;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Region("Users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private int age;
	
	public User(UserRequest request) {
		this.name=request.getName();
		this.age=request.getAge();
		this.id=UUID.randomUUID().hashCode();
	}
}
