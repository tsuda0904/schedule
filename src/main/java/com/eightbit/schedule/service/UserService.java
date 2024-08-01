package com.eightbit.schedule.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eightbit.schedule.entity.User;
import com.eightbit.schedule.model.UserUpdateQuery;
import com.eightbit.schedule.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	/**
	 * ★ユーザ名検索
	 * @param searchQuery
	 * @return 特定ユーザデータ(複数)
	 */
	public List<User> searchUser(String searchQuery) {
		ArrayList<User> userList = new ArrayList<>();
		
		userList.addAll(userRepo.findByFirstNameContaining(searchQuery));
		userList.addAll(userRepo.findByLastNameContaining(searchQuery));
		
		return userList;
	}
	
	/**
	 * ★特定ユーザ検索
	 * @param userId
	 * @return 特定ユーザデータ
	 */
	public User searchUserById(int userId) {
		User user = new User();
		user = userRepo.findById((long)userId).get();
		
		return user;
	}
	
	/**
	 * ★特定のユーザデータを削除する
	 * @param userId
	 */
	public void deleteUserData(int userId) {
		userRepo.deleteById((long)userId);
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
		uuq.setMail(user.getMail());
		uuq.setAddress(user.getAddress());
		uuq.setCourse(user.getCourse());
		uuq.setPosition(user.getPosition());

		return uuq;
	}
	
	/**
	 * ★特定ユーザデータ情報更新
	 * @param uuq
	 */
	public void updateUser(UserUpdateQuery uuq) {
		User user = new User();
		
		user = userRepo.findByUserId(uuq.getUserId());
		user.setUserId(uuq.getUserId());
		user.setLastName(uuq.getLastName());
		user.setFirstName(uuq.getFirstName());
		user.setTel(uuq.getTel());
		user.setMail(uuq.getMail());
		user.setAddress(uuq.getAddress());
		user.setCourse(uuq.getCourse());
		user.setPosition(uuq.getPosition());
		
		userRepo.save(user);
	}
	
	/**
	 * ★ユーザ情報新規登録
	 * @param user
	 * @param birth
	 */
	public void userRegist(User user, String birth) {
		user.setBirth(ServiceUtility.parseDate(birth));
		Date now = new Date();
		user.setUserRegistered(now);
		System.out.println(user);
		userRepo.save(user);
	}
}