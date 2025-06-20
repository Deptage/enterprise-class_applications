import React, { useEffect, useState } from 'react';
import ProductItem from './ProductItem';
import axios from 'axios';

const ProductList = ({}) =>{
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

    return (
        <div>
            <h1>List of Products</h1>
            <ul>
                {products.map(product => (
                    <ProductItem
                        key={product.id}
                        id={product.id}
                        title={product.title}
                        brand={product.brand}
                    />
                ))}
            </ul>
        </div>
    );
}

export default ProductList;