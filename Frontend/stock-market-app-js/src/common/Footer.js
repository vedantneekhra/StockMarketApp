import React from "react";
import styles from "./Footer.module.scss";

export default function Footer() {
  const GITHUB = "https://github.com/vedantneekhra/";

  const TRADINGVIEW = "https://www.tradingview.com/";
  const IEX_CLOUD = "https://iexcloud.io/";

  return (
    <footer className={styles.footer}>
      <p className={styles.text}>
        Created by{" "}
        <a href={GITHUB} className={styles.person}>
          Vedant Neekhra
        </a>.
      </p>
      <p className={styles.text}>Built using Spring and React.</p>
      <p className={styles.text}>
        Stock Market data courtesy of{" "}
        <a href={IEX_CLOUD} className={styles.otherLink}>
          IEX Cloud
        </a>
        , and charts obtained from{" "}
        <a href={TRADINGVIEW} className={styles.otherLink}>
          Trading View
        </a>
        .
      </p>
    </footer>
  );
}
