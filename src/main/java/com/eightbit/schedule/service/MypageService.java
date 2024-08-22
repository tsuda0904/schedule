package com.eightbit.schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eightbit.schedule.entity.User;
import com.eightbit.schedule.model.SecuritySession;
import com.eightbit.schedule.model.UserUpdateQuery;
import com.eightbit.schedule.repository.LoginUserRepository;
import com.eightbit.schedule.repository.UserRepository;

@Service
public class MypageService {
	@Autowired
	private LoginUserRepository loginUserRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SecuritySession securitySession;
	
	/**
	 * ★ログインユーザ検索
	 * @return ログインユーザデータ
	 */
	public User searchUserById() {
		User user = new User();
		user = userRepo.findByMail(securitySession.getUsername());
		System.out.println(user);
		return user;
	}
	
	/**
	 * 登録情報変更時パラメータ受け取り用
	 * @param user
	 * @return パラメータ格納モデル
	 */
	public UserUpdateQuery getUserDto(User user) {
		UserUpdateQuery uuq = new UserUpdateQuery();
		
		uuq.setUserId(user.getUserId());
		uuq.setLastName(user.getLastName());
		uuq.setFirstName(user.getFirstName());
		uuq.setTel(user.getTel());
//		uuq.setMail(user.getMail());
		uuq.setAddress(user.getAddress());
		uuq.setCourse(user.getCourse());
		uuq.setPosition(user.getPosition());

		return uuq;
	}
	
	/**
	 * ★特定ユーザデータ情報更新
	 * @param uuq
	 */
	public void updateMypage(UserUpdateQuery uuq) {
		User user = new User();
		
		user = userRepo.findByMail(securitySession.getUsername());
		user.setLastName(uuq.getLastName());
		user.setFirstName(uuq.getFirstName());
		user.setTel(uuq.getTel());
//		user.setMail(uuq.getMail());
		user.setAddress(uuq.getAddress());
		user.setCourse(uuq.getCourse());
		user.setPosition(uuq.getPosition());
		
		userRepo.save(user);
	}
	
	
}