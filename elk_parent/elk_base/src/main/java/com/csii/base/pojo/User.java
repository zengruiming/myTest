package com.csii.base.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{

	@Id
	private Long id;//

	private String username;//用户名
	private String password;//密码，加密存储
	private String phone;//注册手机号
	private java.util.Date created;//创建时间
	private String salt;//密码加密的salt值

}
