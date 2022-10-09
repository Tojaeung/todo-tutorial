import React from 'react';
import styles from 'styles/layout.module.css';

interface IProps {
  children: React.ReactNode;
}

function Layout({ children }: IProps) {
  return (
    <div className={styles.layout}>
      <h1 className={styles.title}>Todo</h1>
      {children}
    </div>
  );
}

export default Layout;
