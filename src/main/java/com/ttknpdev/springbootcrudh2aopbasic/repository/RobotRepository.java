package com.ttknpdev.springbootcrudh2aopbasic.repository;

import com.ttknpdev.springbootcrudh2aopbasic.entity.Robot;
import org.springframework.data.repository.CrudRepository;

public interface RobotRepository extends CrudRepository<Robot,Long> { }
