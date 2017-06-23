import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {Http, Response, URLSearchParams} from "@angular/http";
import {Monitoring} from "../model/monitoring.url.model";
import {AuthHttp} from "angular2-jwt";

const url = '/api/monitoring';

@Injectable()
export class MonitoringUrlService {

    constructor(private http: Http, private authHttp: AuthHttp) {

    }

    create(monitoring: Monitoring): Observable<Response> {
        return this.http.post(url, monitoring)
            .catch((error: any) => {
                return Observable.throw(error);
            });
    }

    delete(id: number): Observable<Response> {
        return this.authHttp.delete(`${url}/${id}`)
            .catch((error: any) => {
                return Observable.throw(error);
            });
    }

    getUrls(): Observable<Monitoring[]> {
        return this.authHttp.get(`${url}/getUrls`).map(resp => resp.json());
    }

}
