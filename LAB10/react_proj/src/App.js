import logo from './logo.svg';
import './App.css';
import ProductList from './ProductList';
import React, { useEffect, useState } from 'react';
import ProductItem from './ProductItem';
import axios from 'axios';
import { BrowserRouter, Routes, Route, createBrowserRouter, RouterProvider } from 'react-router-dom';
import ProductDetails from './ProductDetails';

function App() {
  const [products, setProducts] =useState([]);

  useEffect(() => {
        const fetchProducts = async () => {
            const response = await fetch('https://dummyjson.com/products');
            if (!response.ok) {
                throw new Error('Failed to fetch products');
            }
            const data = await response.json();
            setProducts(data.products);
        };

        fetchProducts();
    }, []);
  const router = createBrowserRouter([
    {
      path: "/",
      element: <ProductList products={products}/>
    },
    {
      path: "/details/:id",
      element: <ProductDetails products={products} />
    }
  ]);
  return <RouterProvider router={router} />;
}

export default App;
