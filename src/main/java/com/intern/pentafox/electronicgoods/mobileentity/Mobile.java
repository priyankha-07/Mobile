package com.intern.pentafox.electronicgoods.mobileentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mobile")
public class Mobile {
    @Id
    @Generated
    int id;
    String name;
    double price;
    String colour;

}
