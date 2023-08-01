package com.micro.rating.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_ratings")
public class Rating {

    @Id
    public  String ratingId;

    private String userId;
    private String hotelId;
    private String rating;
    private  String remark;
    private String feedback;




}
