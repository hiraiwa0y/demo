package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MessageMapper {
	@Select("SELECT text FROM messages ORDER BY id")
	List<Message> findAll();
	
	@Select("SELECT id, text FROM messages where id = #{id}")
	List<Message> findById(int id);
	
	@Insert("INSERT INTO messages(text) VALUES(#{text})")
	int create(Message message);
}
