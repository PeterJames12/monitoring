import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {HttpModule, RequestOptions, Http} from "@angular/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ToastModule} from "ng2-toastr";
import {ChartsModule} from "ng2-charts";
import {ClientComponent} from "./pages/client/client.component";
import {ClientsService} from "./pages/client/ClientsService";
import {Ng2FilterPipeModule} from "ng2-filter-pipe";
import {AppComponent} from "./app.component";
import {CacheService} from "ionic-cache";
import {MonitoringComponent} from "./pages/monitoring/monitoring.component";
import {MonitoringUrlService} from "./service/monitoring.url.service";
import {AuthHttp, AuthConfig} from "angular2-jwt";

@NgModule({
  declarations: [
    AppComponent,
    ClientComponent,
    MonitoringComponent
  ],
  imports: [
    Ng2FilterPipeModule,
    ChartsModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    ToastModule.forRoot(),
  ],
  providers: [
    CacheService,
    MonitoringUrlService,
    [{
      provide: AuthHttp,
      useFactory: authHttpServiceFactory,
      deps: [Http, RequestOptions]
    }]
  ],
  bootstrap: [AppComponent]
})


export class AppModule {
}

export function authHttpServiceFactory(http: Http, options: RequestOptions) {
  return new AuthHttp(new AuthConfig({
    noClientCheck: true }), http, options);
}

