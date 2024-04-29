linear_extrude(height = 3.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
{
    intersection()
    {
        rotate(45.0)
        {
            union()
            {
                scale([42.42640687119285, 5.0])
                {
                    M14();
                }
                rotate(90.0)
                {
                    scale([42.42640687119285, 5.0])
                    {
                        M14();
                    }
                }
            }
        }
        scale([30.0, 30.0])
        {
            M14();
        }
    }
}

module M14()
{
    polygon
    (
        points =
        [
            [-0.5, -0.5], 
            [0.5, -0.5], 
            [0.5, 0.5], 
            [-0.5, 0.5]
        ],
        paths =
        [
            [0, 1, 2, 3]
        ]
    );
}
