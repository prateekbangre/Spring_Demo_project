package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author prateek.bangre on 08/11/21.
 * @Project demo
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="log")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int logId;
    String type;
    String dateTime;
    String data;

}
