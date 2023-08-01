package com.micro.user.service.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    public  String ratingId;
    private String userId;
    private String hotelId;
    private String rating;
    private  String remark;
    private String feedback;

    private Hotel hotel;

}
