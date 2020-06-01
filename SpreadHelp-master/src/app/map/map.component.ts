import {Component, OnInit, AfterViewInit} from '@angular/core';
import * as L from 'leaflet';
@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit, AfterViewInit {

  private map;
  smallIcon = new L.Icon({
    iconUrl: 'https://cdn0.iconfinder.com/data/icons/small-n-flat/24/678111-map-marker-512.png?',
    iconSize:    [24, 24],
    iconAnchor:  [12, 24],
    popupAnchor: [0, -24],
  });

  constructor() { }

  ngOnInit() {
  }
  ngAfterViewInit(): void {
    this.createMap();
  }
  createMap() {
    const parcThabor = {
      lat: 35.7542668,
      lng: 10.7754199,
    };

    const zoomLevel = 5.5 ;

    this.map = L.map('map', {
      center: [parcThabor.lat, parcThabor.lng],
      zoom: zoomLevel
    });

    const mainLayer = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      minZoom: 5.5,
      maxZoom: 17,
      attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    });

    mainLayer.addTo(this.map);
    const descriptionWikipedia = `Monestir`;
    const popupOptions = {
      coords: parcThabor,
      text: descriptionWikipedia,
      open: true
    };
    this.addMarker(popupOptions);
  }

  addMarker({coords, text, open}) {
    const marker = L.marker([coords.lat, coords.lng], { icon: this.smallIcon });
    if (open) {
      marker.addTo(this.map).bindPopup(text).openPopup();
    } else {
      marker.addTo(this.map).bindPopup(text);
    }
  }

}

