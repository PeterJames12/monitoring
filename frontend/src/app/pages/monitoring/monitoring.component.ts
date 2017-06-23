import {Component, Injectable, OnInit} from "@angular/core";
import {MonitoringUrlService} from "../../service/monitoring.url.service";
import {ToastsManager} from "ng2-toastr";
import {Monitoring} from "../../model/monitoring.url.model";

@Component({
    selector: 'monitoring_url',
    templateUrl: 'monitoring.component.html',
    styleUrls: ['monitoring.component.html']
})
@Injectable()
export class MonitoringComponent implements OnInit{

    monitoring: Monitoring[];

    constructor(private monitoringService: MonitoringUrlService,
                private toast: ToastsManager) {
    }

    ngOnInit(): void {
        this.monitoringService.getUrls().subscribe((monitoring: Monitoring[]) => {
            this.monitoring = monitoring;
        });
    }

    print(){
        this.monitoringService.getUrls().subscribe((monitoring: Monitoring[]) => {
            this.monitoring = monitoring;
            this.toast.success(this.monitoring[0].url + ".ua");
        });
    }
}