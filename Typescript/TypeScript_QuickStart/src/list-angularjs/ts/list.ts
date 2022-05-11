import * as _from 'underscore';
export class Item {
    constructor(public name : string, public point : number){}

}

export class RecommendedPlaces {
    getBestPlace(items: Array<Item>) : string {
        let bestPlace = _.max(items, function(i) {return i.point});
        return bestPlace.name;
    }
}