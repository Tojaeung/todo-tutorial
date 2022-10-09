import type { NextPage } from 'next';
import Head from 'next/head';

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
