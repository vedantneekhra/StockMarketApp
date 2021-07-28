import React from "react";
import styles from "./RemoveCompany.module.scss"
import RedButton from "../common/RedButton";
import Card from "../common/Card";

export default class Users extends React.Component {
  constructor(props) {
    super(props);

    this.state = { users: [
      {
        username: "vneekhra@gmail.com",
        name: "Vedant",
        role: "Admin, User"
      },
      {
        username: "dummmy1@gmail.com",
        name: "Dummy1",
        role: "User"
      },
      {
        username: "dummmy2@gmail.com",
        name: "Dummy2",
        role: "User"
      },
      {
        username: "dummmy3@gmail.com",
        name: "Dummy3",
        role: "User"
      },
    ]};

    this.deleteUser = this.deleteUser.bind(this);

  }

  deleteUser(key){
    console.log(key);
    return (e) => {
        console.log(key);
        this.setState({users : 
            this.state.users.filter(
                user => user.username !== key)});
        // Add axios to remove the user from backend
    };
  }

  render() {

    return (
      <div className = {styles.maincontainer}>
        <Card title="Users" >
        <table >
          <thead>
            <tr>
              <th className = {styles.table}>Username</th>
              <th className = {styles.table}>Name</th>
              <th className = {styles.table}>Roles</th>
              <th className = {styles.table}>Delete</th>
            </tr>
          </thead>
          <tbody>
            {this.state.users.map((user, index) => {
              return (
                <tr key={user.username}>
                  <td className = {styles.table}>{user.username}</td>
                  <td  className = {styles.table}>{user.name}</td>
                  <td  className = {styles.table}>{user.role}</td>
                  <td  className = {styles.table}>
                      <RedButton
                      id={user.username}
                      onClick={this.deleteUser(user.username)}
                      >
                          Delete
                          </RedButton>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
        </Card>
      </div>
    );
  }
}
