import type { NextPage } from 'next';
import Head from 'next/head';
import Layout from 'components/Layout';
import TodoList from 'components/TodoList';

const Home: NextPage = () => {
  return (
    <div>
      <Head>
        <title>todo</title>
        <meta name="description" content="todo" />
        <link rel="icon" href="/favicon.ico" />
      </Head>
      <Layout>
        <TodoList />
      </Layout>
    </div>
  );
};

export default Home;
