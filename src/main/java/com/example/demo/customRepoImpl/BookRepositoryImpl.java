package com.example.demo.customRepoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.example.demo.customRepo.BookCustomRepository;
import com.example.demo.dto.BookDto;
import com.example.demo.model.Author;
import com.example.demo.model.Book;

public class BookRepositoryImpl implements BookCustomRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<BookDto> findAll(String bookLabel, String authorFamilyName, String authorName) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<BookDto> query = cb.createQuery(BookDto.class);
		Root<Book> bookRoot = query.from(Book.class);
		Root<Author> authorRoot = query.from(Author.class);

		List<Predicate> filterPredicates = new ArrayList<>();
		filterPredicates.add(cb.equal(bookRoot.get("authorId"), authorRoot.get("id")));
		if (bookLabel != null && !bookLabel.isEmpty()) {
			filterPredicates.add(cb.like(bookRoot.get("label"), bookLabel));
		} else if (authorFamilyName != null && !authorFamilyName.isEmpty()) {
			filterPredicates.add(cb.like(authorRoot.get("familyName"), authorFamilyName));
		} else if (authorName != null && !authorName.isEmpty()) {
			filterPredicates.add(cb.like(authorRoot.get("name"), authorName));
		}
		if (bookLabel != null && !bookLabel.isEmpty()) {
			filterPredicates.add(cb.like(bookRoot.get("label"), bookLabel));
		} else if (authorFamilyName != null && !authorFamilyName.isEmpty()) {
			filterPredicates.add(cb.like(authorRoot.get("familyName"), authorFamilyName));
		} else if (authorName != null && !authorName.isEmpty()) {
			filterPredicates.add(cb.like(authorRoot.get("name"), authorName));
		}
		query.select(cb.construct(BookDto.class, bookRoot.get("label"), authorRoot.get("familyName"),
				authorRoot.get("name"), bookRoot.get("pageCount")))
				.where(cb.and(filterPredicates.toArray(new Predicate[0])));
		return entityManager.createQuery(query).getResultList();
	}
}
