// 지식이의 게임개발2

function make_map(가로, 세로, 캐릭터, 장애물, 움직임){
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

    console.log(움직임);

    let 캐릭터의위치 = [캐릭터[0] +1, 캐릭터[1] + 1];

    let x = 캐릭터의위치[1];
    let y = 캐릭터의위치[0];

    world_map[y][x] = 0; 

    for(let i of 움직임){
        console.log(i);

        if(i == 1 && world_map[y-1][x] != 2){
            y -= 1;
        }else if(i == 2 && world_map[y+1][x] != 2){
            y += 1;
        }else if(i == 3 && world_map[y][x-1] != 2){
            x -= 1;
        }else if(i == 4 && world_map[y-1][x] != 2){
            x += 1;
        }

       

        world_map[y][x] = 1; 
        for(let i of world_map){
            console.log(i);
        }
        
    }
    

};

make_map(5, 4, [0, 0], [[0,1],[1,1],[2,3],[1,3]], [2,2,2,4,4,4]);