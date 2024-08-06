


/*
import App from './App.vue'
import { createApp, reactive } from 'vue';
import { createRouter, createWebHashHistory } from 'vue-router';
import BootstrapVue3 from 'bootstrap-vue-3'
import { BootstrapIconsPlugin } from 'bootstrap-icons-vue'; // 1.10.3 #26288
import { Modal } from 'bootstrap'


createApp(App).mount('#app')

const screens = [
	{
		name: 'pick',
		path: '/pick/:lagerzone',
	},
	{
		name: 'login',
		path: '/'
	},
	{
		name: 'hauptmenu',
		path: '/hauptmenu'
	},
	{
		name: 'bereitstellung',
		path: '/bereitstellung',
		children: [
			'pupt-etikett',
			'pupt-fach',
			'gt-etikett',
			'gt-fach',
			'etikett-zuordnen-hinweis',
			'etikett-zuordnen-positionen',
			'etikett-zuordnen-neu',
		],
	},
	{
		name: 'fachkontrolle',
		path: '/fachkontrolle/:id?'
	}
];



app.use(BootstrapVue3);
app.use(BootstrapIconsPlugin);

app.use(i18n);

app.component('error-popup', componentErrorPopup);
app.component('problem-popup', componentProblemPopup);
app.component('fach-nummer', componentFachNummer);
app.component('anzeige-stueckelung', componentAnzeigeStueckelung);
app.component('anschnitt-nummer', componentAnschnittNummer);
app.component('input-focus', componentInputFocus);
app.component('action-btn', componentActionBtn);
app.component('screen-module-scan', componentScreenModuleScan);

app.use(router);

app.config.devtools = true;

// Vue3 Weg um service-components global zugaenglich zu machen:
// Die einzelnen components muessen sich hier reinschreiben, wenn sie created() sind.
app.config.globalProperties.$s = reactive({ bereitstellung: undefined });	// 's' wie 'service' oder 'store'

app.mount('#wms-pda');
*/