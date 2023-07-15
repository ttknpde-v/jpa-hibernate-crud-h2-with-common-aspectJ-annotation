package com.ttknpdev.springbootcrudh2aopbasic.dao;

import com.ttknpdev.springbootcrudh2aopbasic.entity.Robot;
import com.ttknpdev.springbootcrudh2aopbasic.exception.handler.ResourceNotFound;
import com.ttknpdev.springbootcrudh2aopbasic.log.Logging;
import com.ttknpdev.springbootcrudh2aopbasic.repository.RobotRepository;
import com.ttknpdev.springbootcrudh2aopbasic.service.RobotService;
import org.apache.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RobotDao extends Logging implements RobotService<Robot> {
    private RobotRepository repository;
    @Autowired
    public RobotDao(RobotRepository repository) {
        this.repository = repository;
    }
    private Boolean validate(Robot robot){
        if (robot.getPrice() >= 500000 && !(robot.getName().trim().isEmpty()) && robot.getStatus().equals("enable") || robot.getStatus().equals("unenable")) {
            robotDao.log(Level.DEBUG,"robot {} : valid data");
            return true;
        }
        else {
            robotDao.log(Level.DEBUG,"robot {} : invalid data");
            return false;
        }
    }

    @Override
    public Robot creaet(Robot obj) {
        if (validate(obj)) {
            return repository.save(obj);
        }
        else return null;
    }

    @Override
    public Robot read(Long id) {
        return repository.findById(id).orElseThrow(()->{
            throw  new ResourceNotFound("not found id "+id);
        });
    }

    @Override
    public List<Robot> reads() {
        List<Robot> robots = new ArrayList<>();
        repository.findAll().forEach(robots::add);
        if (robots.size() >0 ) {
            return robots;
        }
        else throw new ResourceNotFound("nothing rows in robot table");
    }

    @Override
    public Robot update(Robot obj, Long id) throws ResourceNotFound {
        return repository.findById(id).map(robot -> {
            robot.setName(obj.getName());
            robot.setPrice(obj.getPrice());
            robot.setStatus(obj.getStatus());
            if (validate(robot)){
                repository.save(robot);
            }
            return robot;
        }).orElseThrow(()->{
            throw new ResourceNotFound("not found id "+id);
        });
    }

    @Override
    public Map<String, Robot> delete(Long id) throws ResourceNotFound {
        Map<String,Robot> response = new HashMap<>();
        return repository.findById(id)
                .map(robot -> {
                    repository.delete(robot);
                    response.put("deleted",robot);
                    return response;
                }).orElseThrow(()->{
                    throw new ResourceNotFound("not found id "+id);
                });
    }
}
