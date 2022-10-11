import React from 'react';

interface IProps {
  children: React.ReactNode;
}

function Layout({ children }: IProps) {
  return (
    <div>
      <h1>Todo</h1>
      {children}
    </div>
  );
}

export default Layout;
