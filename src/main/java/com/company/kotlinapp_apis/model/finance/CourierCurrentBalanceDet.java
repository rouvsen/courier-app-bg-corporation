package com.company.kotlinapp_apis.model.finance;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourierCurrentBalanceDet {

    @Id
    private Long id;

    private Integer price;
    private String date;
    private String time;
}
