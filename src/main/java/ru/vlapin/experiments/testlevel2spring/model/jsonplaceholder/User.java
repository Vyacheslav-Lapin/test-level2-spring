package ru.vlapin.experiments.testlevel2spring.model.jsonplaceholder;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class User {

  Long id;
  String name;
  String username;
  String email;
  Address address;
  String phone;
  String website;
  Company company;
}
