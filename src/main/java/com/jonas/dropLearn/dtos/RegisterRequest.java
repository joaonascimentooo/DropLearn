package com.jonas.dropLearn.dtos;

import com.jonas.dropLearn.enums.Role;

public record RegisterRequest(String name, String email, String password, Role role){
}
