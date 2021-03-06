package com.example.mycovid19.Repo.Admin;

import com.example.mycovid19.Model.MyProfile;
import com.example.mycovid19.Service.Admin.SeeAllUsersService;
import java.sql.SQLException;
import java.util.List;

import com.example.mycovid19.Service.Backup.BackupService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SeeAllUsersRepo {

  private static SeeAllUsersService seeAllUsersService;
  private static JdbcTemplate jdbc;

  public SeeAllUsersRepo(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public List<MyProfile> fetchAllUsers() throws SQLException {
    System.out.println(seeAllUsersService.ResultSet());
    //BackupService.printMemberList();
    return seeAllUsersService.ResultSet();
  }

  // UPDATE
  public int updateUser (MyProfile user){
    //update user table
    String sql = "UPDATE user SET first_name = ?, last_name = ?, date_of_birth = ? WHERE user_id = ?";
    return jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getDateOfBirth(), user.getUserId());
  }

  public int updateUserContactData (MyProfile user){
    //update user contact data table
    String sql = "UPDATE user_contact_data SET phone_number = ?, street_name = ?, home_number = ?, district = ? WHERE user_id = ?";
    return jdbc.update(sql, user.getPhoneNumber(), user.getStreetName(), user.getHomeNumber(), user.getUserDistrict(), user.getUserId());
  }

  public int updateUserCredentials (MyProfile user){
    //update user credentials table
    String sql = "UPDATE user_credentials SET email = ?, password = ? WHERE user_id = ?";
    return jdbc.update(sql, user.getUserEmail(), user.getUserPassword(), user.getUserId());
  }


  public int deleteUser (String userId){
    //delete user by id
    System.out.println(userId);
    String sql = "DELETE FROM user WHERE user_id = ?";
    return jdbc.update(sql, userId);
  }

}
