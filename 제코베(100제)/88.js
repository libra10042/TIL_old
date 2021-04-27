// 지식의 게임 개발

function make_map(가로, 세로, 캐릭터, 장애물){
    let world_map = [];
    for(let i =0; i<세로 + 2; i++){
        world_map.push(Array(가로 + 2).fill(0));
    }

    for(let i in world_map){
        for(let j in world_map[0]){
            if(i == 0 || j == 0 || j == world_map[0].length -1 || i == world_map.length -1){
                world_map[i][j] = 2; 
            }
        }
    }
    
    world_map[캐릭터[0] + 1][캐릭터[1] + 1] = 1;
    console.log(world_map);

    for(let i of 장애물){
        if(world_map[i[0] + 1][i[1] + 1] == 1){
            world_map[i[0] + 1][i[1] +1] = 1; 
        }else{
            world_map[i[0] + 1][i[1] +1] = 2; 
        }
    }

    for(let i of world_map){
        console.log(i);
    }

    

};

make_map(5, 4, [0, 0], [[0,1],[1,1],[2,3],[1,3]]);