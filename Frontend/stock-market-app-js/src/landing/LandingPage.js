import React from "react";
import styles from "./LandingPage.module.scss";
import Header from "../common/Header";
import LandingSection from "./LandingSection";
import Footer from "../common/Footer";
import TextField from '@material-ui/core/TextField';
import StockPrice from "./StockPrice";

const config = {
  headers: {
    "content-type": "application/json",
    authorization: "",
  },
  responseType: "json",
};

export default function LandingPage() {
  
  
    const GITHUB = "https://github.com/vedantneekhra/";
    const LINKEDIN = "https://www.linkedin.com/in/shintaro-onuma/";
    const top100Films = [
      { title: 'Dangal', year: 2016 },
      { title: 'The Sting', year: 1973 },
      { title: '2001: A Space Odyssey', year: 1968 },
      { title: "Singin' in the Rain", year: 1952 },
      { title: 'Toy Story', year: 1995 },
      { title: 'Bicycle Thieves', year: 1948 },
      { title: 'The Kid', year: 1921 },
      { title: 'Inglourious Basterds', year: 2009 },
      { title: 'Snatch', year: 2000 },
      { title: '3 Idiots', year: 2009 },
      { title: 'Monty Python and the Holy Grail', year: 1975 },
    ];
    
    return (
      <div>
        <Header />
        <LandingSection title="Stock Price" alt={true}>
          <StockPrice />
          </LandingSection>
        <LandingSection title="About Us" alt={true}>
          <h2>Vedant Neekhra</h2>
          <p className={styles.p}>
            Graduate, IIT Roorkee 
          </p>
          <p className={styles.p}>
            I am interested in the intersection between finance and technology.
          </p>
          <p className={styles.links}>
            <a href={GITHUB}>GitHub</a> |{" "}
            <a href={LINKEDIN}>LinkedIn</a>
          </p>
        </LandingSection>
        <LandingSection title="Our Motivations" alt={false}>
          <p className={styles.p}>
            I chose two popular web technologies to cover
            fundamental concepts used in full-stack projects: <b> Spring </b> and <b>React</ b>.
            These allowed us to construct the frontend and backend within Ten days.
            The potential to rapidly develop and scale ideas on the web is ideal
            for our future entrepreneurial ventures and personal projects.
          </p>
        </LandingSection>
        <Footer />
      </div>
    );

  
}

