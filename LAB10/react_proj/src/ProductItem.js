import React, { useEffect, useState } from 'react';

const ProductItem = ({id, title, brand}) =>{
    return (
        <li>
            {title} ({brand})
        </li>
    );
}

export default ProductItem;