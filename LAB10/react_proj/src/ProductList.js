import React, { useEffect, useState } from 'react';
import ProductItem from './ProductItem';
import axios from 'axios';

const ProductList = ({products}) =>{
    const [filter, setFilter] =useState('')

    const onFilterChange = (event) => {
        setFilter(event.target.value);
    }

    return (
        <div>
            <h1>List of Products</h1>
            <label>Filter by product title
                <input type="text" value={filter} onChange={onFilterChange}/>
            </label>
            <ul>
                {products.filter(product => product.title.includes(filter)).map(product => (
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