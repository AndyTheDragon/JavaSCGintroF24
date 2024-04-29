scale([20.0, 20.0, 20.0])
{
    rotate_extrude(angle = 360.0, $fn = 32)
    {
        M37();
    }
}

module M37()
{
    polygon
    (
        points =
        [
            [0.0, 0.0], 
            [3.061616997868383E-17, -0.5], 
            [0.09754516100806417, -0.4903926402016152], 
            [0.19134171618254492, -0.46193976625564337], 
            [0.27778511650980114, -0.4157348061512726], 
            [0.3535533905932738, -0.35355339059327373], 
            [0.4157348061512726, -0.2777851165098011], 
            [0.46193976625564337, -0.1913417161825449], 
            [0.4903926402016152, -0.09754516100806412], 
            [0.5, 0.0], 
            [0.4903926402016152, 0.09754516100806412], 
            [0.46193976625564337, 0.1913417161825449], 
            [0.4157348061512726, 0.2777851165098011], 
            [0.3535533905932738, 0.35355339059327373], 
            [0.27778511650980114, 0.4157348061512726], 
            [0.19134171618254492, 0.46193976625564337], 
            [0.09754516100806417, 0.4903926402016152], 
            [3.061616997868383E-17, 0.5]
        ],
        paths =
        [
            [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17]
        ]
    );
}
