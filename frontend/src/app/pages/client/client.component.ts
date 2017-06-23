import {Component, Injectable} from "@angular/core";
import {
    ArticleService
} from './shared/articleservice';
import {IClients} from "./IClients";
import {ClientsService} from "./ClientsService";


@Component({
    selector: 'clients',
    templateUrl: 'client.component.html',
    styleUrls: ['client.components.css']
})

@Injectable()
export class ClientComponent {

    constructor() {
    }

    ngOnInit(): void {
    }
}
