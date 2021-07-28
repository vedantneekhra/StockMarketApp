import React from "react";
import styles from "./StockPrice.module.scss";
import Header from "../common/Header";
import LandingSection from "./LandingSection";
import Footer from "../common/Footer";
import TextField from '@material-ui/core/TextField';
import Autocomplete from '@material-ui/lab/Autocomplete';
import axios from "../api/axios";
import { StylesProvider } from "@material-ui/core";
import Button from "./Button";

const config = {
    headers: {
      "content-type": "application/json",
    },
    responseType: "json",
  };

var stockExchangeList = ["NSE", "BSE"];

var companyListAllStockExchange = {"NSE": ["RTL", "DUC", "ITC"], "BSE": ['XYZ', 'QWE', 'INF', 'RBX']};



export default function StockPrice(){

    const [stockExchange, setStockExchange] = React.useState('');
    const [company, setCompany] = React.useState('');
    const [companyList, setCompanyList] = React.useState([]);
    
    const [foundStockExchange, setFoundStockExchange] = React.useState('');
    const [foundCompany, setFoundCompany] = React.useState('');

    
    function getPrice(){
        console.log("Getting price");
        setFoundStockExchange(stockExchange);
        setFoundCompany(company);
    }
    // axios.get('/companyByStockExchange/')
    //     .then((res) => {
    //         setCompanyList(res.data);
    //     });

    return (
        <div>
            <div className={styles.flexbox}>
            <Autocomplete
                inputValue={stockExchange}
                onInputChange={(event, newValue) => {
                    setStockExchange(newValue);
                    if(newValue != ''){
                      setCompanyList(companyListAllStockExchange[newValue]);
                    }
                }
                }
                id="combo-box"
                options={stockExchangeList}
                getOptionLabel={(option) => option}
                className={styles.autoCompleteBox}
                renderInput={(params) => <TextField {...params} label="Stock Exchange"  />}
            />

            <Autocomplete
                inputValue={company}
                onInputChange={(event, newValue) => {
                    setCompany(newValue);
                }
                }
                id="combo-box"
                options={companyList}
                getOptionLabel={(option) => option}
                className={styles.autoCompleteBox}
                renderInput={(params) => <TextField {...params} label="Company Name"  />}
            />

            <Button
                id="submit"
                className={styles.button}
                onClick={getPrice}
              >
                Submit
              </Button>
            
            </ div>
            { foundCompany ?
              <div className={styles.price}> Price of {foundCompany} in {foundStockExchange} is 12.9 at 2021-07-18 19:57:51.000000 </div>
              : <div></div>
            }
        </div>
        );

}