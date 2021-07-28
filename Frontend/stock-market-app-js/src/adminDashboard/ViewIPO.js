import React from "react";
import styles from "./RemoveCompany.module.scss"
import RedButton from "../common/RedButton";
import Card from "../common/Card";

export default class ViewIPO extends React.Component {
  constructor(props) {
    super(props);

    this.state = { ipo: [
      {
        id: 2001,
        companyId: 1001,
        companyName: "Jubliant Foods",
        pricePerStock: 24,
        totalStocks: 1234121,
        date: "2011-07-18"
      },
      {
        id: 2002,
        companyId: 1002,
        companyName: "Cipla",
        pricePerStock: 56,
        totalStocks: 43453634,
        date: "2012-03-12"
      },
      {
        id: 2003,
        companyId: 1003,
        companyName: "Tata Motors",
        pricePerStock: 86,
        totalStocks: 463344241,
        date: "2000-09-03"
      },
      {
        id: 2004,
        companyId: 1004,
        companyName: "Zomato",
        pricePerStock: 122,
        totalStocks: 7673178,
        date: "2021-07-18"
      },

    ]};

    this.deleteIpo = this.deleteIpo.bind(this);

  }

  deleteIpo(key){
    console.log(key);
    return (e) => {
        console.log(key);
        this.setState({ipo : 
            this.state.ipo.filter(
                ipo => ipo.id !== key)});
        // Add axios to remove the user from backend
    };
  }

  render() {

    return (
      <div className = {styles.maincontainer}>
        <Card title="IPOs" >
        <table >
          <thead>
            <tr>
              <th className = {styles.table}>Company Id</th>
              <th className = {styles.table}>Company Name</th>
              <th className = {styles.table}>Price Per Stock</th>
              <th className = {styles.table}>Total Stocks</th>
              <th className = {styles.table}>Date</th>
              <th className = {styles.table}>Delete</th>
            </tr>
          </thead>
          <tbody>
            {this.state.ipo.map((ipo, index) => {
              return (
                <tr key={ipo.id}>
                  <td className = {styles.table}>{ipo.companyId}</td>
                  <td  className = {styles.table}>{ipo.companyName}</td>
                  <td  className = {styles.table}>{ipo.pricePerStock}</td>
                  <td  className = {styles.table}>{ipo.totalStocks}</td>
                  <td  className = {styles.table}>{ipo.date}</td>
                  <td  className = {styles.table}>
                      <RedButton
                      id={ipo.id}
                      onClick={this.deleteIpo(ipo.id)}
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
