package com.example.demo.customRepo;

import java.util.List;

import com.example.demo.dto.BookDto;

public interface BookCustomRepository {

	List<BookDto> findAll(String bookLabel, String authorFamilyName, String authorName);

}
