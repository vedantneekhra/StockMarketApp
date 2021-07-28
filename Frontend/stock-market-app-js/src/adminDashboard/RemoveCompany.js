import React from "react";
import styles from "./RemoveCompany.module.scss"
import RedButton from "../common/RedButton";
import Card from "../common/Card";

export default class ViewStockPane extends React.Component {
  constructor(props) {
    super(props);

    this.state = { companies: [
      {
        id: 1001,
        stockExchange: "NSE",
        name: "Reliance",
        sectorId: 1
      },
      {
        id: 1002,
        stockExchange: "NSE",
        name: "ITC",
        sectorId: 2
      },
      {
        id: 1003,
        stockExchange: "NSE",
        name: "LnT",
        sectorId: 3
      },
      {
        id: 1004,
        stockExchange: "NSE",
        name: "Infosys",
        sectorId: 1
      },
    ]};

    this.deleteCompany = this.deleteCompany.bind(this);

  }

  deleteCompany(key){
    console.log(key);
    return () => {
        this.setState({ companies : 
        this.state.companies.filter(
            company => company.id !== key)});
    }
  }

  render() {

    return (
      <div className={styles.maincontainer}>
        <Card title="Remove Company" >
        <table >
          <thead>
            <tr>
              <th className = {styles.table}>S.No.</th>
              <th className = {styles.table}>Company Name</th>
              <th className = {styles.table}>Stock Exchange</th>
              <th className = {styles.table}>Sector ID</th>
              <th className = {styles.table}>Delete</th>
            </tr>
          </thead>
          <tbody>
            {this.state.companies.map((company, index) => {
              return (
                <tr key={company.id}>
                  <td  className = {styles.table}>{index + 1}</td>
                  <td  className = {styles.table}>{company.name}</td>
                  <td className = {styles.table}>{company.stockExchange}</td>
                  <td className = {styles.table}>{company.sectorId}</td>
                  <td  className = {styles.table}>
                      <RedButton
                      id={company.id}
                      onClick={this.deleteCompany(company.id)}
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
