package com.spring.example.repository;

import com.spring.example.dto.CategoryDto;
import com.spring.example.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findByCode(Integer aLong);

   List<Category>  findAllByCode(Integer code);

   List<Category> deleteAllByCode(Integer code);

    void deleteByCode(Integer code);
}
