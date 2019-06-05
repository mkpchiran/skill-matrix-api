package com.wiley.internal.apps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiley.internal.apps.domain.User;

public interface UserRepository extends JpaRepository<User, String> { }

