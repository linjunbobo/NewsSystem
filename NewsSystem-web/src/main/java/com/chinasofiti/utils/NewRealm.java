package com.chinasofiti.utils;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.New;
import com.chinasofiti.service.IManagerService;

/**
 * 
 * @author Bo
 *
 */
public class NewRealm extends AuthorizingRealm {
	@Autowired
	private IManagerService managerService;
	//执行授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	//执行认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		//得到令牌
		UsernamePasswordToken toke =(UsernamePasswordToken)token;
		
		
		Manager manager = new Manager();
		manager.setAccount(toke.getUsername());
		manager.setPassword(new String(toke.getPassword()));
		List<Manager> managers = managerService.findBy(manager);
		if(managers.size()>0) {
			manager=managers.get(0);
			return new SimpleAuthenticationInfo(manager,manager.getPassword(), manager.getAccount());
		}
		return null;
	}

}
