package com.example.demo.repository;

import com.example.demo.model.Log;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * @author prateek.bangre on 08/11/21.
 * @Project demo
 */
@Repository
@Transactional
public interface LogRepository extends CrudRepository<Log, String> {

    @Query("SELECT COUNT(*) from log where type=?1 and date_time<=?2 and date_time>=?3")
    public int getCountOfType(String type, String startDateTime, String endDateTime);
}
