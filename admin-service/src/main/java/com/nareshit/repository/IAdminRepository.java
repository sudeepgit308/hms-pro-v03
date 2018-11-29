package com.nareshit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.domain.Admin;
@Repository
public interface IAdminRepository extends CrudRepository<Admin, Integer> {

}
