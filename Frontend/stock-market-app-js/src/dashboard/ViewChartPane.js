import React from "react";
import styles from "./ViewChartPane.module.scss";
import Card from "../common/Card";
import {Line} from 'react-chartjs-2';
import TextField from '@material-ui/core/TextField';
import Autocomplete from '@material-ui/lab/Autocomplete';
import Button from "../landing/Button";

var stockExchangeList = ["NSE", "BSE"];
var companyListAllStockExchange = {"NSE": ["RTL", "DUC", "ITC"], "BSE": ['XYZ', 'QWE', 'INF', 'RBX']};
var companyStockPrice = {
  'RTL':{
      label: 'RTL',
      data: [10, 15, 30, 10, 32, 32, 43, 53, 51, 76],
      fill: false
    },
  'DUC':{
      label: 'DUC',
      data : [5, 4, 9, 11, 14, 21, 12, 11, 9, 9],
      fill: false
    }
  };
export default class ViewChartPane extends React.Component {
  constructor(props) {
    super(props);

    this.state = { 
      company : '',
      stockExchangeList: stockExchangeList,
      companyList: [],
      stockExchange: '',
      chartData: {
        labels: ['2021-07-18 19:57:51.000000', '2021-07-18 19:57:52.000000', '2021-07-18 19:57:53.000000', 
        '2021-07-18 19:57:54.000000', '2021-07-18 19:57:55.000000', '2021-07-18 19:57:56.000000', '2021-07-18 19:57:57.000000', 
        '2021-07-18 19:57:58.000000', '2021-07-18 19:57:59.000000', '2021-07-18 19:58:00.000000'],
        datasets:[
          
        ]
      }
    };

    this.getData = this.getData.bind(this);

  }

  getData(){
    if(this.state.chartData.datasets.length > 0){
      this.state.chartData.datasets.pop();
    }
    this.state.chartData.datasets.push(companyStockPrice[this.state.company]);
    this.setState({chartData: this.state.chartData } );
    console.log(this.state.chartData);
  }

  render() {

    return (
      <div>
        <Card title="Charts">
        <div>
            <div className={styles.flexbox}>
            <Autocomplete
                inputValue={this.state.stockExchange}
                onInputChange={(event, newValue) => {
                    this.setState({stockExchange: newValue});
                    if(newValue != ''){
                      this.setState({companyList : companyListAllStockExchange[newValue]});
                    }
                }
                }
                id="combo-box"
                options={this.state.stockExchangeList}
                getOptionLabel={(option) => option}
                className={styles.autoCompleteBox}
                renderInput={(params) => <TextField {...params} label="Stock Exchange"  />}
            />

            <Autocomplete
                inputValue={this.state.company}
                onInputChange={(event, newValue) => {
                    this.setState({company: newValue});
                }
                }
                id="combo-box"
                options={this.state.companyList}
                getOptionLabel={(option) => option}
                className={styles.autoCompleteBox}
                renderInput={(params) => <TextField {...params} label="Company Name"  />}
            />

            <Button
                id="submit"
                className={styles.button}
                onClick={this.getData}
              >
                Submit
              </Button>
            
            </ div>
        </div>
        <Line
          data={this.state.chartData}
          options={{
            // title:{
            //   display:this.props.displayTitle,
            //   text:'Largest Cities In '+this.props.location,
            //   fontSize:25
            // },
            legend:{
              display:this.props.displayLegend,
              position:this.props.legendPosition
            },
            scales: {
              yAxes: [{
                  ticks: {
                      beginAtZero: true
                  }
              }],
              xAxes: [{
                  type: 'time',
              }]
          }
          }}
        />

          </Card>
        </div>
    );
  }
}
